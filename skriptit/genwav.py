import wave, struct, math, random

naytteenOttoTaajuus = 44100.0 # hertsiä
kesto = 5.0 # sekuntia
taajuus = 440.0 # HZ

clip = wave.open('440hz.wav', 'w')

clip.setnchannels(1)
clip.setsampwidth(2)
clip.setframerate(naytteenOttoTaajuus)

for i in range(int(naytteenOttoTaajuus * kesto)):
   arvo = math.sin(2 * math.pi * taajuus * i / naytteenOttoTaajuus)
   if i < 25:
     print(int(arvo * 32767.0))
   data = struct.pack('<h', int(arvo * 32767.0))
   clip.writeframes(data)

clip.close()
