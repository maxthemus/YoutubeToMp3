from pytube import YouTube
import sys

#PATH FOR SAVING VIDEO TO
#BY DEFAULT IS THE FILES DIR
PATH="./files/"

#setting up input from file
reader = open("urls.txt", "r")

#Loop logic
#1- Read name
#2- Download file
line = "start"#so that the loop executes first tiem
while line:
    line = reader.readline()
    
    #checking to see if no string
    if line == "":
        continue

    line.rstrip("\n")
    #Formatting is (name___url)
    split = line.split("___", 1)
    name = split[0]
    url = split[1]

    print("Dowloading : ",name + " : " + url, end="")

    #downloading file
    try:
        yt = YouTube(line)
    except:
        print("COULDN'T FIND ", line)
        continue
    

    #yt.set_filename(name)
    try:
        yt.streams.filter(file_extension="mp4").first().download(PATH)
    except Exception as ex:
        print(ex)
        print("FAILD TO DOWNLAOD :" + name)
        continue


print("DONE Downloading")
reader.close()
