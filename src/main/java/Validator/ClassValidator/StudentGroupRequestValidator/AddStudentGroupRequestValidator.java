package Validator.ClassValidator.StudentGroupRequestValidator;

import Request.StudentGroupRequest.AddStudentGroupRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentGroupRequestValidator implements IClassValidator<AddStudentGroupRequest> {
    @Override
    public List<String> validate(AddStudentGroupRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        if (!NameValidator.validate(request.getName(), maxLen))
            list.add("Name should be not null and less than " + maxLen + " symbols");
        return list;
    }
}
