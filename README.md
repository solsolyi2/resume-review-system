# Resume Review System

**Resume Review System**은 구직자가 제출한 이력서를 기반으로  
**현업 리뷰어가 항목별 점수와 개선 피드백을 제공하는 리뷰 플랫폼**입니다.

---

## 🎯 배경과 목적

구직 활동 중 많은 지원자들이 단순한 "불합격" 통보만 받고,  
**무엇이 부족했는지 알 수 없어 개선 기회를 놓치고 있습니다.**

> 이 프로젝트는 단순한 이력서 작성 툴이 아닙니다.  
> **지원자의 이력서를 리뷰어가 실제로 평가하고,  
정량적 점수와 정성적 피드백을 통해 개선을 유도하는 "자기주도형 경력 관리 도구"입니다.**

### 이 프로젝트를 통해 실현하고자 하는 목표는 다음과 같습니다:

- **지원자의 입장에서 유의미한 피드백 시스템 실험**
- **도메인 기반 백엔드 아키텍처 학습 및 구조화된 설계 적용**
- Kotlin, Spring Boot, Hexagonal 구조, Precompiled Plugin 등  
  **현업에서 사용되는 스택을 실제처럼 구성**
- JWT 인증, RBAC 권한 분리 등  
  **운영 관점 기능까지 고려한 전체 시스템 설계 실습**

---

## 🏗️ 프로젝트 구조

### 📦 멀티 모듈 구성

| 모듈명        | 역할 설명 |
|--------------|-----------|
| `user`       | 사용자 도메인 (이름, 이메일, 상태, 역할 등) |
| `review`     | 이력서 및 경력 평가 도메인 (추후 개발 예정) |
| `core`       | 공통 기능 모음 (`common-jwt` 등) |
| `app`        | Spring Boot 실행 애플리케이션 |

### 🔧 주요 기술 스택

- **언어**: Kotlin (JVM 21)
- **프레임워크**: Spring Boot 3.5.3, Spring Security
- **아키텍처**: Hexagonal Architecture (도메인/애플리케이션/어댑터)
- **빌드**: Gradle Kotlin DSL, Precompiled Plugins
- **데이터베이스**: H2 (개발용), PostgreSQL (운영 예정)
- **테스트**: Kotest, JUnit5, Instancio
- **기타**: JWT 인증, RBAC, GitOps 기반 YAML 버전 관리 예정

---

## ⚙️ 기술적 선택 이유

### ✅ Hexagonal Architecture

- **도메인 중심 설계**를 통해 비즈니스 로직과 외부 시스템 의존성 분리
- 테스트 용이성 및 유지보수성 향상
- 실제 서비스에 가까운 아키텍처 훈련

### ✅ Precompiled Plugin 도입

- 모듈 수 증가 시 Gradle 설정 반복 문제 해결
- `bootstrap`, `common` 플러그인으로 중복 제거 및 통일된 개발 환경 구성
- 신규 모듈 생성 시 **빠르고 일관된 설정 적용**

### ✅ 도메인 불변성 보장 (`private set`, 정적 팩토리 방식)

```kotlin
class User private constructor(
    val id: UserId,
    val email: Email,
    val name: String,
    val role: Role,
    val status: UserStatus,
) {
    companion object {
        fun create(...) = ...
    }
}
```
* **도메인 객체는 외부에서 변경 불가능한 상태를 유지**해야 하므로 생성자를 `private`으로 제한
* 생성/변경은 정적 팩토리 메서드 또는 도메인 내 행위 메서드에서만 가능하도록 제한함으로써 **불변성 및 정합성 보장**

---

### 🧱 주요 기술 스택

* **언어**: Kotlin (JVM 21)
* **프레임워크**: Spring Boot 3.5.3, Spring Security
* **아키텍처**: Hexagonal Architecture (domain, application, adapter 분리)
* **빌드 도구**: Gradle (Kotlin DSL) + Precompiled Plugins
* **DB**: H2 (개발), PostgreSQL (운영 예상)
* **테스트**: Kotest, JUnit5, Instancio
* **기타**: JWT, RBAC, GitOps 기반 YAML 이력관리 예정

---

## 🧪 테스트 및 품질

* Kotest 기반 단위 테스트 구성
* instancio를 활용한 객체 생성
* 테스트 클래스/메서드 한글 네이밍 전략 적용 (`상태_행동_결과`)
* ArchUnit을 통한 계층 간 의존성 검증 예정

---

## 👤 기여자

* **이솔** / 백엔드 개발자 
