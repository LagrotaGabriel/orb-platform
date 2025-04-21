package orb.com.backend.modules.cup.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import orb.com.backend.modules.cup.models.enums.CupColorEnum;
import orb.com.backend.modules.cup.models.enums.CupModelEnum;
import orb.com.backend.modules.metrics.models.entity.CupMetricsEntity;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@DynamicUpdate
@NoArgsConstructor
@Table(name = "tb_orb_cup")
public class CupEntity {

    @Id
    @Comment("Primary key of the cup - UUID")
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cod_cup_cup", nullable = false, updatable = false)
    private UUID id;

    @CreationTimestamp
    @Comment("Creation date and time of the cup")
    @Column(name = "ldt_creation_cup", nullable = false, updatable = false)
    private LocalDateTime creationLocalDateTime;

    @UpdateTimestamp
    @Comment("Last update date and time of the cup")
    @Column(name = "ldt_update_cup", nullable = false)
    private LocalDateTime lastSyncDateTime;

    @Comment("Indicates if the cup is activated")
    @Column(name = "bln_activated_cup", nullable = false)
    private Boolean isActivated;

    @Comment("Cup model")
    @Enumerated(EnumType.STRING)
    @Column(name = "enm_model_cup", nullable = false)
    private CupModelEnum model;

    @Comment("Cup color")
    @Enumerated(EnumType.STRING)
    @Column(name = "enm_color_cup", nullable = false)
    private CupColorEnum color;

    @JoinTable(
            name = "tb_orb_cup_metrics",
            joinColumns = @JoinColumn(name = "cod_cup_cup"),
            inverseJoinColumns = @JoinColumn(name = "cod_metrics_mtc")
    )
    @Comment("Cup metrics")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CupMetricsEntity> metrics = new ArrayList<>();

    public CupEntity(CupModelEnum model, CupColorEnum color) {
        this.creationLocalDateTime = LocalDateTime.now();
        this.lastSyncDateTime = LocalDateTime.now();
        this.isActivated = false;
        this.model = model;
        this.color = color;
    }
}
