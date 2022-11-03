import os
import ffmpeg

inputDIR = "./files/"
outputDIR = "./output/"

for fileName in os.listdir(inputDIR):
    name = fileName.rstrip(".mp4")
    name = name+".mp3"
    input = ffmpeg.input(inputDIR+fileName)
    input = ffmpeg.output(input, outputDIR+name)
    ffmpeg.run(input, overwrite_output=True) 

for fileName in os.listdir(inputDIR):
    os.remove(inputDIR+fileName)