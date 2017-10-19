package WordCount;



import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper <LongWritable, Text, Text, IntWritable> {
  
  // create these guys up here for speed
  private final static IntWritable one = new IntWritable (1);
  private Text word = new Text();
  
  // create a Pattern object to parse each line
  private final Pattern wordPattern = Pattern.compile ("[a-zA-Z][a-zA-Z0-9]+");
  
  public void map (LongWritable key, Text value, Context context) throws IOException, InterruptedException {        
    // put your code here!
  } 
  
}
