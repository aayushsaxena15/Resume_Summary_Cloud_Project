f2=open("records","w")
s="Resume.id#Resume.name#Resume.email#Resume.Phone_Number#Resume.Years_of_Exp#Resume.Specialization#Resume.CGPA#Resume.college_undergrad#Resume.college_postgrad\n"
f2.write(s)
content=[]
ctr=1
with open("MapReduce_Output") as f:
    content = f.readlines()
for i in range(len(content)):
    content[i] = content[i].replace(",", ";")
    f2.write(str(i+100)+"#"+content[i])
    
