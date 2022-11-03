from urllib.request import urlopen
import re


#setting up input from file
reader = open("./temp/names.txt", "r")

#setting up output to file
writer = open("urls.txt", "w")

baseUrl = "https://www.youtube.com/results?search_query="

line = "start"
while line:
    line = reader.readline()
    line = line.rstrip("\n")
    if line == "":
        continue
    print("Reading : ",line)
    name = line.replace(" ", "+")

    try:
        #url to search
        url = baseUrl+name

        page = urlopen(url)
        html_bytes = page.read()
        html = html_bytes.decode("utf-8")

        #extracting video id from html file
        name = re.findall('/watch.*,', html)
        split = name[1].split(",", 1)
        name = split[0]
        name = name.rstrip('"')

        #putting link together
        baseLink = "https://www.youtube.com"
        linkToVdieo = baseLink+name

        #printing link to file
        print(line+"___"+linkToVdieo, file=writer)
    except:
        continue


print("DONE Getting Urls")
reader.close()
writer.close()





