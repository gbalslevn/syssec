from Crypto.Util.number import getStrongPrime, GCD, inverse, getRandomInteger
from hashlib import sha256
import math
import os

# RSA Signatures, Implementing RSA-PSS (Task 3)

sizeN = 3072
saltSize = 32

def G (): 
    print("Generating the keys....")
    e = getRandomInteger(sizeN) 
    p = getStrongPrime(sizeN // 2, e=e)
    q = getStrongPrime(sizeN // 2, e=e)
    while p == q:
        p = getStrongPrime(sizeN // 2, e=e)
        q = getStrongPrime(sizeN // 2, e=e)
    
    N = p * q
    
    phi = (p-1)*(q-1)
    while GCD(e, phi) > 1:
        e = getRandomInteger(sizeN) 
           
    d = inverse(e, phi)
    print(f'Done generating keys. d={str(d)[:5]}..., e={str(e)[:5]}..., N={str(N)[:5]}...')
    return N, e, d 

def S(m, d, N):
    # According to https://datatracker.ietf.org/doc/html/rfc8017#section-9.1.1
    if len(m) > (2**61 - 1): 
        raise ValueError("message too long")
    mHash = sha256hash(m)
    hLen = len(mHash)
    emLen = (sizeN + 7) // 8
    if emLen < hLen + saltSize + 2:
        raise ValueError("Length of N should be larger")
    
    salt = os.urandom(saltSize)
    
    m_prime = b'\x00' * 8 + mHash + salt
    H = sha256hash(m_prime)
    
    PS = b'\x00' * (emLen - saltSize - hLen - 2)
    DB = PS + b'\x01' + salt
    dbMask = MGF(H, emLen - hLen - 1)
    maskedDB = bytes(a ^ b for a, b in zip(DB, dbMask))
    bits_to_clear = 8 * emLen - sizeN
    if bits_to_clear:
        mask = (0xFF >> bits_to_clear)
        maskedDB = bytes([maskedDB[0] & mask]) + maskedDB[1:]
        
    EM = maskedDB + H + b'\xbc'
    s = pow(int.from_bytes(EM, byteorder='big'), d, N)
    return s
         
def V(m, s, e, N):
    mHash = sha256hash(m)
    hLen = len(mHash)
    emLen = (sizeN + 7) // 8
    EM = pow(s, e, N)
    EM = EM.to_bytes(emLen,byteorder='big')
    print(EM)
    if EM[-1] != 0xbc:
        print(f"Error: Rightmost byte must be 0xbc and not {EM[-1]}.")
        return False  
    maskedDB = EM[:emLen - hLen - 1]
    H = EM[emLen - hLen - 1 : emLen - 1]
    
    bits_to_clear = 8 * emLen - sizeN
    if bits_to_clear:
        mask = (0xFF >> bits_to_clear)
        if maskedDB[0] & (~mask) != 0:
            print("Error: Leftmost 8emLen - bitsize of modulo must be zero.")
            return False 
    
    dbMask = MGF(H, emLen - hLen - 1)
    DB = bytes(a ^ b for a, b in zip(maskedDB, dbMask))
    
    if bits_to_clear:
        mask = (0xFF >> bits_to_clear)
        DB = bytes([DB[0] & mask]) + DB[1:]
        
    psLen = emLen - hLen - saltSize - 2
    if any(byte != 0 for byte in DB[:psLen]):
        return False  # "inconsistent"
    if DB[psLen] != 0x01:
        return False  # "inconsistent"
    
    salt = DB[-saltSize:] if saltSize > 0 else b""
    
    m_prime = b'\x00' * 8 + mHash + salt
    
    H_prime = sha256hash(m_prime)
    return H == H_prime
    
def sha256hash(m):
    return sha256(m).digest()

# Mask generation function based on a hash function. 
def MGF(seed, mask_len):
    T = b""
    hLen = sha256().digest_size
    # Loop counter from 0 until enough output is produced.
    for counter in range(math.ceil(mask_len / hLen)):
        C = counter.to_bytes(4, byteorder='big')  # 4-octet counter
        T += sha256hash(seed + C)
    return T[:mask_len]
    
N, e, d = G()
print("Which message do you want to sign?")
m = input()
m = m.encode()
s = S(m, d, N)
v = V(m, s, e, N)
print(f"The signature is: {s}")
print(f"The (s,m) is: {v}")



### To test RSA key generation. 
def E(m, e, N):
    c = pow(int.from_bytes(m), e, N)
    return c

def D(c, d, N):
    m = pow(c, d, N)
    m_bytes = m.to_bytes((m.bit_length() + 7) // 8, 'big')
    return m_bytes.decode()

ct = E(m, e, N)
pt = D(ct, d, N)
# print(f"The ciphertext is: {ct}")
# print(f"The plaintext is: {pt}")