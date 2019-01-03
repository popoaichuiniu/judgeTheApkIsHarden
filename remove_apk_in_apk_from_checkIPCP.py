checkIPCPermissionAPK=open("checkIPCPermissionAPK","r")
checkIPCPermissionAPK_remove_child_apk=open("checkIPCPermissionAPK_remove_child_apk","w")
lines=checkIPCPermissionAPK.readlines()
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
            checkIPCPermissionAPK_remove_child_apk.write(content+"\n")
checkIPCPermissionAPK_remove_child_apk.close
checkIPCPermissionAPK.close
