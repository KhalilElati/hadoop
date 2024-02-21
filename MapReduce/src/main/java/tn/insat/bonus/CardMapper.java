package tn.insat.bonus;

import org.apache.hadoop.io.Text;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class CardMapper extends Mapper<LongWritable, Text, Text, IntWritable > {
      private final static IntWritable one = new IntWritable(1);
        private Text cardType = new Text();

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] parts = value.toString().split("\t");
            System.out.println(parts);
            if (parts.length >= 6) {
                String card = parts[5]; // Assuming card type is the last field
                cardType.set(card);
                context.write(cardType, one);
                
            }
        }
    }


