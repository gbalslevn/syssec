import requests
import os

# CBC Padding Oracle (Task 1)

BLOCK_SIZE = 16

def oracle(iv, block):
    new_ciphertext = bytes(iv) + block
    print(new_ciphertext.hex())
    res = requests.get(f'https://cbc.syssec.dk/quote/', cookies={'authtoken': new_ciphertext.hex()})
    print(res.text)
    
    if "incorrect" in res.text:
        return False 
    return True 

def singleBlockDecryption(ct_block, iv): 
    forged_iv = list(iv)
    decrypted_bytes = [0] * BLOCK_SIZE # Keep track of all decrypted bytes in this block
    
    for pad_val in range(1, BLOCK_SIZE + 1): # pad_val is 0x01, 0x02, ..., 0x16
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

ciphertext = bytes.fromhex('3436a595f70aa12d505d00a073e2c9ab5243d19ea4f4a8a6b6a716505a5e4b7244090d7d32e0c9d631393ec745866d1e9cb0f3ce8c7ef22def9f352ff981fbf59ec86d71aaf15ba54b0226a955bd99ab1f71e88af6fc13c461cca5ce2ab51c09') # Cookie from the home page
iv, ct = ciphertext[:BLOCK_SIZE], ciphertext[BLOCK_SIZE:]
print(decrypt(ct, iv))
plaintext_solution = b'I must use authenticated encryption since ... plain CBC is not secure!'
lastCtBlock = ct[len(ct)-BLOCK_SIZE:] 
ciphertext_solution = encrypt(plaintext_solution, lastCtBlock)
print(ciphertext_solution.hex())