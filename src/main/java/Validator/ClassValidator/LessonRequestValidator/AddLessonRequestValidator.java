package Validator.ClassValidator.LessonRequestValidator;

import Request.LessonRequest.AddLessonRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.DateValidator;
import Validator.SimpleValidator.IdValidator;
import Validator.SimpleValidator.ListValidator;

import java.util.ArrayList;
import java.util.List;

public class AddLessonRequestValidator implements IClassValidator<AddLessonRequest> {
    @Override
    public List<String> validate(AddLessonRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getSubjectId())) list.add("SubjectId should be >= 0");
        if (!DateValidator.validate(request.getDate()))
            list.add("Date should be in dd/mm/yyyy format with correct date");
        if (!IdValidator.validate(request.getNumber())) list.add("Lesson number should be >= 0");
        if (!IdValidator.validate(request.getTeacherId())) list.add("TeacherId should be >= 0");
        if (!IdValidator.validate(request.getGroupId())) list.add("GroupId should be >= 0");
        if (!ListValidator.validate(request.getAttendanceList())) list.add("AttendanceList should be not null and without null elements");
        return list;
    }
}
