# MicroServices Collector

## Idea

- Services register themselves on something like zk, informing their name+version and their dependencies (name+version);
- Frontends (customer facing services, etc) register themselves with a special flag;
- The tool assembles a dependency graph and mark the ones that are not required anymore.


## Why

You can deploy new services of versions of them as needed, pointing to any depending system version. If a frontend is deactivated (by releasing a new version, for instance), the tool will run automatically and detect which of them arenot needed anymore, and claim those resources.
