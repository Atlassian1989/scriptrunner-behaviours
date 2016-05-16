//Script Name : Detected in Test Phase
//Author : Chander Inguva
//Date : 5/16/2016

def airlineField = getFieldByName("Airline")
def ditpField = getFieldById(getFieldChanged())
def selectedOption = ditpField.getValue() as String

if ((selectedOption == "E2E") || (selectedOption == "Alpha") || (selectedOption == "Beta") || (selectedOption == "Production"))
 {
  airlineField.setRequired(true)
 }
else
 {
  airlineField.setRequired(false)
 }