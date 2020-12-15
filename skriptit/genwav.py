import wave, struct, math

def luoWavTiedosto(nimi, kehyksia, tavumaara, kanavia, naytteenOttoTaajuus, taajuusFunktio):
  clip = wave.open(nimi + '.wav', 'w')

  clip.setnchannels(kanavia)
  clip.setsampwidth(tavumaara)
  clip.setframerate(naytteenOttoTaajuus)

  for i in range(int(kehyksia)):
    arvo = taajuusFunktio(i)
    data = struct.pack('<h', int(arvo * 32767.0))
    clip.writeframes(data)

  clip.close()

luoWavTiedosto("440hz", 0.75 * 44100.0, 2, 1, 44100.0, lambda i: math.sin(2 * math.pi * 440.0 * i / 44100.0))
luoWavTiedosto("200hz-400hz-800hz", 0.75 * 44100.0, 2, 1, 44100.0, lambda i: 0.5 * math.sin(2 * math.pi * 200.0 * i / 44100.0) + 0.4 * math.sin(2 * math.pi * 400.0 * i / 44100.0) + 0.1 * math.sin(2 * math.pi * 800.0 * i / 44100.0))
luoWavTiedosto("kymmenykset", 10, 2, 1, 44100.0, lambda i: i / 10.0)
luoWavTiedosto("sr48000-kymmenykset", 10, 2, 1, 48000.0, lambda i: i / 10.0)
luoWavTiedosto("8bit-kymmenykset", 10, 1, 1, 44100.0, lambda i: i / 10.0)
luoWavTiedosto("stereo-kymmenykset", 10, 2, 2, 44100.0, lambda i: i / 10.0)
luoWavTiedosto("32bit-kymmenykset", 10, 4, 1, 44100.0, lambda i: i / 10.0)
