##MATCHING CANDIDATES##

To run this program just pass as a parameter the path to a CSV with the following structure:

contactID,name,name1,email,postalZip,address

The program will create a results.csv file with the following structure:

contactId source,contactId match,Accuracy
470,970,LOW

To match candidates the criteria is
A) If all fields except the contactID match, then it gives SURE accuracy that the candidate is a duplicate
B) If the email is repeated, it gives a HIGH accuracy that there is a duplicate
C) If Name and Address are equal, then the accuracy is MEDIUM
D) If only first and lastname matches, then the accuracy is LOW
E) If non match, it ignores the record