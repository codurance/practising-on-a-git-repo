#!/bin/bash

set -e 

listOfBranches=$(git branch --all | grep -v "/HEAD" | grep -v "/master" | tr '/' ' ' | awk '{print $3}');
listOfBranches=(`echo ${listOfBranches}`);

echo "Checkout out master"
git checkout master

for branchName in "${listOfBranches[@]}"
do
  echo "Checkout out $branchName..."
  git checkout $branchName
done

echo "Checkout out master"
git checkout master