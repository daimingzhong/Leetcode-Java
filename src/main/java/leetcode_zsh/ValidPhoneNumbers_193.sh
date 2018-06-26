#!/usr/bin/env bash

#Example:
#
#Assume that file.txt has the following content:
#
#987-123-4567
#123 456 7890
#(123) 456-7890
#Your script should output the following valid phone numbers:
#
#987-123-4567
#(123) 456-7890
# grep （缩写来自Globally search a Regular Expression and Print

grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt

sed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' file.txt

awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt