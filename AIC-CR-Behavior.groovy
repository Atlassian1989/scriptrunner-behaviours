import com.atlassian.jira.component.ComponentAccessor
def IKDField =  getFieldById(getFieldChanged())
def KDNField = getFieldByName("Kit Document Number")

def selectedOption = IKDField.getValue() as String


if (selectedOption == "Yes")
{
  KDNField.setHidden(false)
  KDNField.setRequired(true)
}
else
 {
   KDNField.setHidden(true)
   KDNField.setRequired(false)
 }
