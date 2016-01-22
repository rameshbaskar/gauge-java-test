# Test various vowels

Some description for the feature (aka Specification in the Gauge world)

The following is a context step that is executed before every scenario
* Vowels in English language are "aeiou".

## Vowel counts in single word

This is a scenario

tags: single word

* The word "gauge" has "3" vowels.

## Vowel counts in multiple word

This is the second scenario in this specification

* Almost all words have vowels
     |Word  |Vowel Count|
     |------|-----------|
     |Gauge |3          |
     |Mingle|2          |
     |Snap  |1          |
     |GoCD  |1          |
     |Rhythm|0          |
