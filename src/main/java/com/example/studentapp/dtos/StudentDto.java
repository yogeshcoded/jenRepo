package com.example.studentapp.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String course;
    @NonNull
    private Long fee;
}
