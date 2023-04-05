package com.up7.datajpatutorial.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name="guardianName",
                column = @Column(
                        name = "guardian_name",
                        nullable = false
                )
        ),
        @AttributeOverride(
                name = "guardianEmail",
                column = @Column(
                        name = "guardian_email",
                        nullable = false
                )
        ),
        @AttributeOverride(
                name = "guardianMobileNumber",
                column = @Column(
                        name = "guardian_mobile_num",
                        nullable = false
                )
        )
})
public class Guardian {

    private String guardianName;
    private String guardianEmail;
    private String guardianMobileNumber;
}
