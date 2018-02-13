# Changelog
All notable changes to PDF SDK are documented in this file.

## [Unreleased]

## [1.1.1] - 2018-02-13
### Added
- Add powershell SDK
- Add public NuGet repository called sphereon-sdk-nuget at [nexus.qa.sphereon.com](http://nexus.qa.sphereon.com) for .NET releases
- Add example Java file conversion application

### Fixed
- GetJobs endpoint returns an array of JobResponse's instead of a single JobResponse previously found in the SDK's. 

## [1.1.0] - 2018-02-06
### Added
- Add proper [storage-ms](https://github.com/Sphereon-SDK) support, meaning it is possible to store and retrieve both input and output files in cloud storage 
- Unify addInputFile endpoints. A new job needs to be created beforehand
- Add lifecycles for both input files, output files and jobs.
- Add javascript SDK 
- Add public NPM repository called sphereon-sdk-npm at [nexus.qa.sphereon.com](http://nexus.qa.sphereon.com) for Javascript/NodeJS releases
- Add documentation