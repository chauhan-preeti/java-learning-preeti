package com.learning.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.learning.util.WriteToFile;

/**
 * Writer thread to split the inputlines
 * 
 * @author preethi
 *
 */
public class ForkJoinWriter extends RecursiveAction {
	
	private static final long serialVersionUID = 8743304963639891871L;

	public ForkJoinWriter(List<String> inputLines) {
		super();
		this.inputLines = inputLines;
	}

	public static final Integer THRESHOLD=10;
	private List<String> inputLines;

	@Override
	protected void compute() {
		if (inputLines.size() > THRESHOLD) {
			ForkJoinWriter.invokeAll(divideIntoSubtasks());
		} else {
			WriteToFile fw = new WriteToFile();
			fw.writeData(inputLines);
		}

	}

	/**
	 * Creates the forkjoinwriter thread 
	 * 
	 * @return list of threads created
	 */
	public List<ForkJoinWriter> divideIntoSubtasks() {
		List<ForkJoinWriter> subtasks = new ArrayList<>();
		Stream<String> partOne=inputLines.stream().limit(THRESHOLD);
		Stream<String> partTwo=inputLines.stream().skip(THRESHOLD);
		subtasks.add(new ForkJoinWriter((List<String>)partOne.collect(Collectors.toList())));
		subtasks.add(new ForkJoinWriter((List<String>)partTwo.collect(Collectors.toList())));
		return subtasks;

	}

}
