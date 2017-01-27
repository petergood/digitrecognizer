#!/bin/bash

segmentAmount=10
minK=1
maxK=30

mailgunApiKey=$(cat "./digitrecognizer/mailgun-api-key")
mailgunDomain=$(cat "./digitrecognizer/mailgun-domain")
emailAddress=$(cat "./digitrecognizer/emailaddr")

message="All of the calculations have been completed! <br>"

echo "Starting k-optimizer with $segmentAmount segments, minK = $minK ; maxK = $maxK"

java -jar digitrecognizer/build/libs/digitrecognizer-1.0-SNAPSHOT.jar $segmentAmount $minK $maxK

echo Starting cleanup...

for ((group=0; group<segmentAmount; group++))
do
    for ((k=$minK; k<=$maxK; k++))
    do
        message="$message $group-$k:$(cat "./$group-$k.txt") <br>"
    done
done

curl -s --user "api:$mailgunApiKey" \
    "https://api.mailgun.net/v3/$mailgunDomain/messages" \
    -F from="DigitRecognizer <postmaster@$mailgunDomain>" \
    -F to="$emailAddress" \
    -F subject='Calculations have been completed!' \
    -F html="$message"
