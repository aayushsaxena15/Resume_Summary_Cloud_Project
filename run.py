import os
import sys
import subprocess

if __name__=='__main__':
    if len(sys.argv) != 3:
        raise "[USAGE] : pyhton run.py <input> <output>"

    input_folder = sys.argv[1]
    output_folder = sys.argv[2]

    # Compile the java files
    command = 'javac doc_mapper_reducer.java'
    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
    stdout, stderr = process.communicate()

    command = 'javac doc_mapper.java'
    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
    stdout, stderr = process.communicate()
        
    command = 'javac doc_reducer.java'
    process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
    stdout, stderr = process.communicate()

    for docfile in os.listdir(input_folder):
        print "Converting File : ",docfile

        # Convert the .doc file to sample.txt (overwrite everytime)
        command = 'antiword '+input_folder+'/'+docfile+' >> sample.txt'
        process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
        stdout, stderr = process.communicate()

        # Will store the path0000 file in the output_folder
        command = 'java doc_mapper_reducer sample.txt '+output_folder
        process = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE)
        stdout, stderr = process.communicate()

    print "Done."
