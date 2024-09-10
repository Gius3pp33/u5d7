package giuseppelongo.u5d7.entities;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private Date dataDiNascita;
    private String avatar;
}
