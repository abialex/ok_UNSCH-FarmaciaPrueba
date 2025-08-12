# 🏥 Sistema de Gestión Farmacéutica - Botica Universitaria

## 📋 Descripción del Proyecto

Sistema integral de gestión farmacéutica desarrollado para la **Universidad Nacional de San Cristóbal de Huamanga (UNSCH)**, diseñado para administrar la botica universitaria, control de inventarios, atención a estudiantes y generación de reportes.

## 🎯 Funcionalidades Principales

### 🏥 **Gestión de Pacientes y Estudiantes**
- Registro y control de estudiantes universitarios
- Gestión de recetas médicas
- Control de atenciones por semestre académico

### 💊 **Administración de Medicamentos**
- Catálogo completo de medicamentos con formas farmacéuticas
- Control de concentraciones y orígenes
- Gestión de lotes con fechas de vencimiento
- Sistema de alertas para medicamentos por agotarse

### 📦 **Control de Inventarios**
- Apertura y cierre de inventarios mensuales
- Alertas automáticas para productos con bajo stock (< 30 unidades)
- Seguimiento de lotes vencidos y por vencer

### 🧾 **Servicios Farmacéuticos**
- Atención personalizada a estudiantes
- Generación automática de recetas
- Control de tarifarios y precios

### 📊 **Reportes y Consultas**
- Reportes por escuela y procedencia
- Estadísticas de diagnósticos
- Control de entregas diarias
- Reportes de inventario y lotes

## 🛠️ Tecnologías y Arquitectura

### **Backend**
- **Java 7** - Lenguaje principal del sistema
- **Hibernate 5.3.6** - ORM para persistencia de datos
- **JPA (Java Persistence API)** - Estándar de persistencia
- **Maven** - Gestión de dependencias y build

### **Base de Datos**
- **Microsoft SQL Server** - Base de datos principal
- **JPA/Hibernate** - Mapeo objeto-relacional
- **Transacciones ACID** - Integridad de datos

### **Frontend**
- **Java Swing** - Interfaz gráfica de usuario
- **NetBeans** - IDE de desarrollo
- **Componentes personalizados** - AutoCompleter, Calendarios

### **Generación de Reportes**
- **iText PDF 7.0** - Generación de documentos PDF
- **Reportes personalizados** - Recetas, inventarios, estadísticas

### **Seguridad y Autenticación**
- **Sistema de roles** - Control de acceso por usuario
- **Sesiones de usuario** - Control de acceso

## 🏗️ Arquitectura del Sistema

### **Patrón MVC (Model-View-Controller)**
```
src/
├── model/          # Entidades JPA (Estudiante, Medicamento, Inventario)
├── Vistas/         # Interfaces de usuario (Swing)
└── app/            # Utilidades y configuración
```

### **Entidades Principales**
- **Estudiante** - Gestión de pacientes universitarios
- **Medicamento** - Catálogo de productos farmacéuticos
- **Inventario** - Control de stock y lotes
- **Receta** - Prescripciones médicas
- **Usuario** - Sistema de autenticación y roles

## 🚀 Características Técnicas Destacadas

### **Persistencia de Datos**
- Mapeo objeto-relacional con JPA/Hibernate
- Relaciones complejas entre entidades
- Consultas optimizadas con JPQL
- Transacciones automáticas

### **Interfaz de Usuario**
- Diseño responsive con Java Swing
- Componentes personalizados y reutilizables
- Validaciones en tiempo real
- Navegación intuitiva entre módulos

### **Generación de Reportes**
- PDFs profesionales con iText
- Plantillas personalizables
- Logos institucionales integrados
- Formato estándar para documentación médica

### **Gestión de Lotes**
- Control de fechas de vencimiento
- Alertas automáticas para productos próximos a vencer
- Trazabilidad completa de medicamentos
- Sistema de rotación FIFO

## 📁 Estructura del Proyecto

```
UNSCH-FarmaciaPrueba/
├── src/main/java/com/ecoedu/
│   ├── model/              # Entidades JPA
│   ├── Vistas/             # Interfaces de usuario
│   │   ├── Consultas/      # Módulos de reportes
│   │   ├── Estudiante/     # Gestión de estudiantes
│   │   ├── Inventario/     # Control de inventarios
│   │   ├── Medicamento/    # Catálogo de medicamentos
│   │   └── ServicioFarmacia/ # Atención farmacéutica
│   └── app/                # Utilidades y configuración
├── src/main/resources/     # Recursos y configuración
├── pom.xml                 # Configuración Maven
└── README.md               # Documentación
```


