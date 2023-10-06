package Validator.ClassValidator.StudentRequestValidator;

import Request.StudentRequest.AddStudentRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;
import Validator.SimpleValidator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentRequestValidator implements IClassValidator<AddStudentRequest> {
    @Override
    public List<String> validate(AddStudentRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        if (!NameValidator.validate(request.getLastName(), maxLen))
            list.add("LastName should be not null and less than " + maxLen + " symbols");
        if (!NameValidator.validate(request.getFirstName(), maxLen))
            list.add("FirstName should be not null and less than " + maxLen + " symbols");
        if (!NameValidator.validate(request.getMiddleName(), maxLen))
            list.add("MiddleName should be not null and less than " + maxLen + " symbols");
        if (!IdValidator.validate(request.getGroupId())) list.add("GroupId should be >= 0");
        return list;
    }
}
