package st.hcmuaf.edu.vn.sche_treatment_project_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "doctor")
@NoArgsConstructor
public class Doctor {
    @Column(name = "doctor_degree", length = 20)
    private String doctorDegree;

    @Column(name = "doctor_rank", length = 20)
    private String doctorRank;

    @Column(name = "doctor_specialty", length = 255)
    private String doctorSpecialty;

    @Column(name = "doctor_introduce", columnDefinition = "TEXT")
    private String doctorIntroduce;

    @Column(name = "doctor_exp", length = 255)
    private String doctorExp;

    @Column(name = "doctor_image", columnDefinition = "TEXT")
    private String doctorImage;

    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account accountId;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Calendar> calendars;
    public Doctor(String doctorDegree, String doctorRank, String doctorSpecialty, String doctorIntroduce, String doctorExp, String doctorImage, Account accountId) {
        this.doctorDegree = doctorDegree;
        this.doctorRank = doctorRank;
        this.doctorSpecialty = doctorSpecialty;
        this.doctorIntroduce = doctorIntroduce;
        this.doctorExp = doctorExp;
        this.doctorImage = doctorImage;
        this.accountId = accountId;
    }
}