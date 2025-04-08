package orb.com.backend.modules.metrics.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_orb_metrics")
public class CupMetricsEntity {

    @Id
    @Comment("Primary key of the metrics - UUID")
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cod_metrics_mtc", nullable = false, updatable = false)
    private UUID id;

    @Comment("Metrics sync date and time")
    @Column(name = "ldt_sync_mtc", nullable = false, updatable = false)
    private LocalDateTime syncDateTime;

    @Comment("Cup temperature")
    @Column(name = "dbl_temperature_mtc", nullable = false)
    private Double temperature;

    @Comment("Cup actual volume")
    @Column(name = "dbl_actualvolume_mtc", nullable = false)
    private Double actualVolume;

    @Comment("Cup remaining volume")
    @Column(name = "dbl_remainingvolume_mtc", nullable = false)
    private Double remainingVolume;

    @Comment("Cup battery percentage")
    @Column(name = "dbl_batterypercentage_mtc", nullable = false)
    private Double batteryPercentage;

    @Comment("Cup is closed")
    @Column(name = "bln_closed_mtc", nullable = false)
    private boolean isClosed;
}
