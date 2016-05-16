//PCRPOC Project
//Script Name: Promo Usage - JIRA Dev
//Author Name : Chander Inguva
//Date : 5/16/2016

def nupuField = getFieldByName("Number of uses per user")
def numuField = getFieldByName("Number of max uses overall of code")
def puField = getFieldById(getFieldChanged())
def selectedOption = puField.getValue() as String

if ((selectedOption != "Restricted Multi-Use?(1-many-1)") || (selectedOption != "Unrestricted Multi-Use? (1-many-many)"))
 {
  nupuField.setFormValue("1")
  numuField.setFormValue("1")
 }
else
 {
  nupuField.setFormValue(" ")
  numuField.setFormValue(" ")
 }
