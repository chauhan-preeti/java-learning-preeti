package com.learning;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForkJoinWriter extends RecursiveAction {

	public ForkJoinWriter(List<String> inputLines) {
		super();
		this.inputLines = inputLines;
	}

	public static final int THRESHOLD=135;
	List<String> inputLines;

	@Override
	protected void compute() {
		if (inputLines.size() > THRESHOLD) {
			ForkJoinWriter.invokeAll(divideIntoSubtasks());
		} else {
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			ForkWriteToFile fw = new ForkWriteToFile();
			fw.writeData(inputLines,timestamp);
		}

	}

	public List<ForkJoinWriter> divideIntoSubtasks() {
		List<ForkJoinWriter> subtasks = new ArrayList();
		Stream<String> partOne=inputLines.stream().limit(THRESHOLD);
		Stream<String> partTwo=inputLines.stream().skip(THRESHOLD);
		subtasks.add(new ForkJoinWriter((List<String>) (List<?>)partOne.collect(Collectors.toList())));
		subtasks.add(new ForkJoinWriter((List<String>) (List<?>)partTwo.collect(Collectors.toList())));
		return subtasks;

	}

}
