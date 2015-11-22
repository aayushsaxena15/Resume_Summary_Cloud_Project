package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


//import com.sun.jersey.core.spi.scanning.Scanner;

public class doc_mapper extends Mapper<LongWritable, Text,LongWritable,Text>{
	int count = 0;
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		count ++;
		String line = value.toString();
        String[]tokens = line.split(":"); 
        
        	
		String caption = tokens[0];
	    String val = tokens[1];
		String field = caption + ", " + val;
        	
        System.out.println(field);	 
           
		context.write(new LongWritable(count),new Text(field));           		
	}			
}


