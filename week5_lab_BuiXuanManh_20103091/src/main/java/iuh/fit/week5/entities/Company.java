    package iuh.fit.week5.entities;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @Table(name = "company")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Company {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "com_id")
        private Long id;
        @Column(name = "comp_name")
        private String name;
        @Column(columnDefinition = "varchar(2000)")
        private String about;
        private String phone;
        @Column(name = "web_url")
        private String webURL;
        private String email;
        @OneToOne
        @JoinColumn(name = "address")
        private Address address;
    }
