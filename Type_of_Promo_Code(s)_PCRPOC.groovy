//PCRPOC Project
//Script Name: Type of Promo Code(s) - JIRA Dev
//Author Name : Chander Inguva
//Date : 5/16/2016

def vanityField = getFieldByName("Vanity/Partial Vanity")
def topcField = getFieldById(getFieldChanged())
def selectedOption = topcField.getValue() as String

if ((selectedOption == "Vanity") || (selectedOption == "Partial Vanity"))
 {
  vanityField.setHidden(false)
 }
else
 {
  vanityField.setHidden(true)
 }