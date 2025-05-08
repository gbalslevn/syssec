import requests
import os
import time

# CBC Padding Oracle (Task 1)

BLOCK_SIZE = 16

def oracle(iv, block):
    new_ciphertext = bytes(iv) + block
    print(new_ciphertext.hex())
    res = requests.get(f'http://127.0.0.1:5000/quote/', cookies={'authtoken': new_ciphertext.hex()})
    print(res.text)
    
    if "incorrect" in res.text:
        return False 
    return True 

def singleBlockDecryption(ct_block, iv): 
    forged_iv = list(iv)
    decrypted_bytes = [0] * BLOCK_SIZE # Keep track of all decrypted bytes in this block
    
    for pad_val in range(1, BLOCK_SIZE + 1): # pad_val is 0x01, 0x02, ..., 0x16
        time.sleep(1)
        for candidate in range(256):
            forged_iv[-pad_val] = candidate  
        
            if oracle(forged_iv, ct_block):
                decrypted_byte = candidate ^ pad_val # d = g xor pad_val
                decrypted_bytes[-pad_val] = decrypted_byte  
                
                # Increment padding to move to next next byte in IV and maintain valid padding. eg. 1 x 0x01 -> 2 x 0x02 padding
                for j in range(1, pad_val + 1):
                    forged_iv[-j] = decrypted_bytes[-j] ^ (pad_val + 1)
                break  
            print(f'Decrypted bytes is: {decrypted_bytes}. Forged_iv is: {forged_iv}')
    return decrypted_bytes

def encrypt(plaintext, lastCtBlock):    
    padding_length = BLOCK_SIZE - (len(plaintext) % BLOCK_SIZE)
    plaintext += bytes([padding_length] * padding_length)
    print(f'Padding length is: {padding_length}')
    print([padding_length] * padding_length)
    
    numberOfBlocks = int(len(plaintext) / BLOCK_SIZE)
    blocks = [plaintext[BLOCK_SIZE * i:(i+1) * BLOCK_SIZE] for i in range(numberOfBlocks)]

    ciphertext = lastCtBlock  # Start with a valid ciphertext block
    
    for pt_block in reversed(blocks):
        iv = os.urandom(BLOCK_SIZE)
        encrypted_bytes = singleBlockDecryption(lastCtBlock, iv)
        
        ciphertext_block = bytes([p ^ enc_byte for p, enc_byte in zip(pt_block, encrypted_bytes)]) 
        ciphertext = ciphertext_block + ciphertext
        print(f'Ciphertext is: {ciphertext}')
        lastCtBlock = ciphertext_block 
    
    return ciphertext

def decrypt(ct, iv):
    numberOfBlocks = int(len(ct) / BLOCK_SIZE)
    blocks = [ct[BLOCK_SIZE * i: (i + 1) * BLOCK_SIZE] for i in range(numberOfBlocks)]
    plaintext = b""
    
    for ct_block in blocks: 
        decrypted_bytes = singleBlockDecryption(ct_block, iv)
        plaintext += bytes([iv_byte ^ dec_byte for iv_byte, dec_byte in zip(iv, decrypted_bytes)]) # pt = IV XOR DT
        print(plaintext)
        iv = ct_block # The prev ct_block is used as IV after round 1. 
    print(f'Last used iv: {iv}')
    print(f'Recovered plaintext: {plaintext}')
    return plaintext

ciphertext = bytes.fromhex('73c3963ffdc33803204bbb653189015361c23fa8212bc5a1e237f3da68561b0500cef030f1855bc66743fc3375bdab0d99e051320de10c3edb20264d39166cc2') # Cookie from the home page
iv, ct = ciphertext[:BLOCK_SIZE], ciphertext[BLOCK_SIZE:]
print(decrypt(ct, iv))
#plaintext_solution = b'I must use authenticated encryption since ... plain CBC is not secure!'
#lastCtBlock = ct[len(ct)-BLOCK_SIZE:] 
#ciphertext_solution = encrypt(plaintext_solution, lastCtBlock)
#print(ciphertext_solution.hex())