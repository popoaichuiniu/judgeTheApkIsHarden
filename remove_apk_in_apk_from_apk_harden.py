apk_harden=open("apk_harden","r")
apk_harden_remove_child_apk=open("apk_harden_remove_child_apk","w")
lines=apk_harden.readlines()
for line in lines:
    content=line.rstrip("\n")
    #print "*"+content+"*"
    if(content!=""):
        count=0
        index=content.find("/")        
        while index!=-1:
            count=count+1                      
            index=content.find("/",index+1)
        if(count>2):
            print ">2"+content


        else:
            print "<=2"+content
            apk_harden_remove_child_apk.write(content+"\n")
apk_harden_remove_child_apk.close
apk_harden.close