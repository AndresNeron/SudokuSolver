#!/bin/bash


number=$1

for x in $(seq 1 9); do
	for y in $(seq 1 9); do
		echo "$x,$y,0" >> "samples/sample.csv"
	done
done

for i in $(seq 3 "$number"); do
	cp "samples/sample.csv" "samples/sample_${i}.csv"
done
