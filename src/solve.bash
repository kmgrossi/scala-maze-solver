#!/bin/bash

echo "Compiling.."
scalac Driver.scala
echo ""

echo -n "Enter input file name: "
read f1
f1="../$f1.png"

scala Driver $f1 ../maze-sol.png
echo "Done.."
