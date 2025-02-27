import base64
import json
import sys
import requests
from Crypto.Util.number import long_to_bytes, bytes_to_long, inverse

# RSA Signatures (Task 2)

def json_to_cookie(j: str) -> str:
    """Encode json data in a cookie-friendly way using base64."""
    # The JSON data is a string -> encode it into bytes
    json_as_bytes = j.encode()
    # base64-encode the bytes
    base64_as_bytes = base64.b64encode(json_as_bytes, altchars=b'-_')
    # b64encode returns bytes again, but we need a string -> decode it
    base64_as_str = base64_as_bytes.decode()
    return base64_as_str

pk = requests.get(f'https://rsasig.syssec.dk/pk/').json()
N = pk["N"]

r = bytes_to_long(b'Computersjov')
r_inv = inverse(r, N)
msg = b'You got a 12 because you are an excellent student! :)'
q = (bytes_to_long(msg) * r_inv) % N

r = hex(r)[2:] # Remove 0x for API to accept the HEX
q = hex(q)[2:]

s_r = requests.get(f'https://rsasig.syssec.dk/sign_random_document_for_students/{r}/').json()["signature"]
s_q = requests.get(f'https://rsasig.syssec.dk/sign_random_document_for_students/{q}/').json()["signature"]
# Now we can use the multiplacative property of RSA
s = (int(s_r, 16) * int(s_q, 16)) % N

c = json_to_cookie(json.dumps({'msg': msg.hex(), 'signature': long_to_bytes(s).hex() }))
resp = requests.get(f'https://rsasig.syssec.dk/quote/', cookies={'grade': c})
print(resp.text)

