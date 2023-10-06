package Validator.ClassValidator.StudentGroupRequestValidator;

import Request.StudentGroupRequest.EditStudentGroupRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;
import Validator.SimpleValidator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentGroupRequestValidator implements IClassValidator<EditStudentGroupRequest> {
    @Override
    public List<String> validate(EditStudentGroupRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        if (!NameValidator.validate(request.getName(), maxLen))
            list.add("Name should be not null and less than " + maxLen + " symbols");
        return list;
    }
}
