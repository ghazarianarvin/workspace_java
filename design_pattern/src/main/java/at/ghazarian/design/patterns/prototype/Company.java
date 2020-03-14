package at.ghazarian.design.patterns.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Company implements Cloneable { // Cloneable: important part of prototyping.

    // all fields are immutable so wie can use clone.
    private Long id;
    private String companyName;
    private LocalDate foundingDate;
    private LocalDate closingDate;

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (Exception e) {
            return null;
        }
    }
}
