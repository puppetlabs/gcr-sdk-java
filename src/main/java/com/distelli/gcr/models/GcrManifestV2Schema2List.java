package com.distelli.gcr.models;

import java.util.List;
import java.util.Collections;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// See https://docs.docker.com/registry/spec/manifest-v2-2/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GcrManifestV2Schema2List implements GcrManifest
{
    public static final String MEDIA_TYPE = "application/vnd.docker.distribution.manifest.list.v2+json";

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ManifestItem {
        public static class ManifestItemBuilder {
            protected String mediaType = GcrManifestV2Schema2.MEDIA_TYPE;
        }
        // Reasonable default:
        protected String mediaType = GcrManifestV2Schema2.MEDIA_TYPE;
        protected int size;
        protected String digest;
        protected Platform platform;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Platform {
        protected String architecture;
        protected String os;
        @JsonProperty("os.version")
        protected String osVersion;
        @JsonProperty("os.features")
        protected List<String> osFeatures;
        protected String variant;
        protected String features;
    }

    public static class GcrManifestV2Schema2ListBuilder {
        protected String mediaType = MEDIA_TYPE;
        protected List<ManifestItem> manifests = Collections.emptyList();
    }

    public int getSchemaVersion() {
        return 2;
    }

    protected String mediaType = MEDIA_TYPE;
    protected List<ManifestItem> manifests = Collections.emptyList();
}