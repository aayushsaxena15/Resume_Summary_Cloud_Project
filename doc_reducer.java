package assignment2;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class doc_reducer extends Reducer< LongWritable,Text,LongWritable,Text>  {
	
	public void reduce (LongWritable keys,Text values, Context context) throws IOException, InterruptedException{		
			context.write(keys,values);
	}
}