Brief Description:
This module first converts the ouptut of map-reduce (MapReduce_Output) to an intermediate file containing resumes in each row and then this file is converted to a csv format.

1) "id.py" converts output of map-reduce to the records file.
2) "parse.py" converts records to mycsv.csv file.

How to Run:
	
	$-> bash run.sh

Note: Place MapReduce_Output file inside folder if not already present.
