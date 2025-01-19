// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: movie.proto

package com.example.movie;

public final class MovieOuterClass {
  private MovieOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetMovieRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetMovieRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetMovieResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetMovieResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CreateMovieRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CreateMovieRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Movie_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Movie_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MovieList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MovieList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DeleteMovieRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DeleteMovieRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DeleteMovieResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DeleteMovieResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013movie.proto\"\035\n\017GetMovieRequest\022\n\n\002id\030\001" +
      " \001(\t\")\n\020GetMovieResponse\022\025\n\005movie\030\001 \001(\0132" +
      "\006.Movie\"Z\n\022CreateMovieRequest\022\r\n\005title\030\001" +
      " \001(\t\022\020\n\010director\030\002 \001(\t\022\r\n\005genre\030\003 \001(\t\022\024\n" +
      "\014release_year\030\004 \001(\005\"Y\n\005Movie\022\n\n\002id\030\001 \001(\t" +
      "\022\r\n\005title\030\002 \001(\t\022\020\n\010director\030\003 \001(\t\022\r\n\005gen" +
      "re\030\004 \001(\t\022\024\n\014release_year\030\005 \001(\005\"#\n\tMovieL" +
      "ist\022\026\n\006movies\030\001 \003(\0132\006.Movie\"\007\n\005Empty\" \n\022" +
      "DeleteMovieRequest\022\n\n\002id\030\001 \001(\t\"%\n\023Delete" +
      "MovieResponse\022\016\n\006status\030\001 \001(\t2e\n\014MovieSe" +
      "rvice\0223\n\014GetMovieById\022\020.GetMovieRequest\032" +
      "\021.GetMovieResponse\022 \n\nListMovies\022\006.Empty" +
      "\032\n.MovieListB\025\n\021com.example.movieP\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_GetMovieRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_GetMovieRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetMovieRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_GetMovieResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_GetMovieResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetMovieResponse_descriptor,
        new java.lang.String[] { "Movie", });
    internal_static_CreateMovieRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CreateMovieRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CreateMovieRequest_descriptor,
        new java.lang.String[] { "Title", "Director", "Genre", "ReleaseYear", });
    internal_static_Movie_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Movie_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Movie_descriptor,
        new java.lang.String[] { "Id", "Title", "Director", "Genre", "ReleaseYear", });
    internal_static_MovieList_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_MovieList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MovieList_descriptor,
        new java.lang.String[] { "Movies", });
    internal_static_Empty_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_DeleteMovieRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_DeleteMovieRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DeleteMovieRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_DeleteMovieResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_DeleteMovieResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DeleteMovieResponse_descriptor,
        new java.lang.String[] { "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
