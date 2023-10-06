package Validator.ClassValidator.SubjectRequestValidator;

import Request.SubjectRequest.DeleteSubjectRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteSubjectRequestValidator implements IClassValidator<DeleteSubjectRequest> {
    @Override
    public List<String> validate(DeleteSubjectRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
