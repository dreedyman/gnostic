
deployment(name: 'Gnostic') {
    groups System.getProperty("org.rioproject.groups", System.getProperty('user.name'))

    artifact id: 'service', 'org.rioproject.gnostic:gnostic-service:5.3'
    artifact id: 'service-api', 'org.rioproject.gnostic:gnostic-api:5.3'

    service(name: 'Gnostic') {
        interfaces {
            classes 'org.rioproject.gnostic.Gnostic'
            artifact ref: 'service-api'
        }
        implementation(class: 'org.rioproject.gnostic.service.GnosticImpl') {
            artifact ref: 'service'
        }
        maintain 1
    }
}
