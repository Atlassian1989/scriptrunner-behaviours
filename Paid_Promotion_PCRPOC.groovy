//PCRPOC Project
//Script Name : Paid Promotion
//Author Name: Chander Inguva
//Date : 5/16/2016
//Behaviour on Paid Promotion Field  (JIRA-DEV)

def ptpiField = getFieldByName("Paid Terms & Partner Information")
def ppField = getFieldById(getFieldChanged())
def selectedOption = ppField.getValue() as String

if ((selectedOption == "No"))
 {
  ptpiField.setHidden(true)
 }
else
 {
  ptpiField.setHidden(false)
 }