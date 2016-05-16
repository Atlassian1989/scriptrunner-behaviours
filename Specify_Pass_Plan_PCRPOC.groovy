//PCRPOC Project
//Script Name: Specify Pass/Plan - JIRA Dev
//Author Name : Chander Inguva
//Date : 5/16/2016

def ptypeField = getFieldByName("Pass Type")
def stpField = getFieldById(getFieldChanged())
def selectedOption = stpField.getValue() as String

if ((selectedOption == "Single Use"))
 {
  ptypeField.setHidden(false)
 }
else
 {
  ptypeField.setHidden(true)
 }