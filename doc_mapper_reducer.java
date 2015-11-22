package assignment2;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class doc_mapper_reducer {
	public static void main(String[] args) throws Exception {
	    if (args.length != 2) {
	      System.err.println("Usage: doc_mapper_reducer <input path> <output path>");
	      System.exit(-1);
	    }
	    
	    Job job = new Job();
	    job.setJarByClass(doc_mapper_reducer.class);
	    job.setJobName("doc_mapper_reducer");

        FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    
	    job.setMapperClass(doc_mapper.class);
	    job.setReducerClass(doc_reducer.class);

	    job.setOutputKeyClass(LongWritable.class);
	    job.setOutputValueClass(Text.class);
	    
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	  }
}
